"""
first:request "/v2/movie/top250"
      request "/v2/movie/search?tag=喜剧"
      request "/v2/movie/search?tag=科幻"
      request "/v2/movie/search?tag=剧情"
second:遍历movies，将其分析并存入数据库

"""
import urllib.request
import urllib.parse
import json
from mysql_conn import get_connection


def request_url(url):
    req = urllib.request.Request(url)
    web_url = urllib.request.urlopen(req)
    data = web_url.read()
    encoding = web_url.info().get_content_charset('utf-8')
    return json.loads(data.decode(encoding))


start = 0
while start < 250:
    top250_url = "https://api.douban.com/v2/movie/top250?start=" + str(start)
    comedy_url = "https://api.douban.com/v2/movie/search?tag=%E5%96%9C%E5%89%A7&start=" + str(start)
    science_url = "https://api.douban.com/v2/movie/search?tag=%E7%A7%91%E5%B9%BB&start=" + str(start)
    plot_url = "https://api.douban.com/v2/movie/search?tag=" + urllib.parse.quote("剧情") + "&start=" + str(start)

    parsed_json = request_url(plot_url)
    movies = parsed_json["subjects"]
    start += 20
    """
    average_rating : movies[0]["rating"]["average"]              : double
    genres         : movies[0]["genres"]                         : list
    title          : movies[0]["title"]                          : string
    images         : movies[0]["small"] | ["large"] | ["medium"] : string
    id             : movies[0]["id"]                             : int
    alt            : "https://movie.douban.com/subject/" + id    : string
    year           : movies[0]["year"]                           : int
    """

# 存入数据库
    connection = get_connection()

    for movie in movies:
        try:
            print(movie["id"])
            with connection.cursor() as cursor:
                sql = "INSERT INTO `reco_movies` VALUES (%s, %s, %s, %s, %s, %s, %s, %s)"
                cursor.execute(sql, (
                    movie["id"], movie["rating"]["average"], "".join(str(e+" ") for e in movie["genres"]), movie["title"], movie["images"]["small"], movie["images"]["medium"],
                    movie["images"]["large"], movie["year"]))
            connection.commit()
        except Exception:
            print(Exception)
            pass

    connection.close()
