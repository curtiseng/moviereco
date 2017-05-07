import pymysql.cursors


# Connect to the database
def get_connection():
    connection = pymysql.connect(host='localhost',
                                 user='root',
                                 password='rootyzf',
                                 db='recommend',
                                 charset='utf8mb4',
                                 cursorclass=pymysql.cursors.DictCursor)
    return connection


    # try:
    #     with connection.cursor() as cursor:
    #         # Create a new record
    #         sql = "INSERT INTO `users` (`email`, `password`) VALUES (%s, %s)"
    #         cursor.execute(sql, ('webmaster@python.org', 'very-secret'))
    #
    #     # connection is not autocommit by default. So you must commit to save
    #     # your changes.
    #     connection.commit()
    #
    #     with connection.cursor() as cursor:
    #         # Read a single record
    #         sql = "SELECT `id`, `password` FROM `users` WHERE `email`=%s"
    #         cursor.execute(sql, ('webmaster@python.org',))
    #         result = cursor.fetchone()
    #         print(result)
    # finally:
    #     connection.close()
