# moviereco

data 文件里放着sql和爬取豆瓣电影数据的python脚本

环境搭建在maven + tomcat8 + java8 + mysql5.7

http://localhost:8080/movie/load?pageNo=1
注：按热点推荐，每页10条数据，可以配置

http://localhost:8080/reco/cf?userId=1
注：用户协同过滤推荐（为用户id为1的用户推荐）
