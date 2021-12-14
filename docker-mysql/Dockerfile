FROM mysql:5.7.25
LABEL maintainer="cboyacanet@hotmail.com"

ENV MYSQL_ROOT_PASSWORD=12345678
ENV MYSQL_DATABASE=restaurantappdb
ENV MYSQL_ROOT_HOST=%

COPY ./scripts-mysql/ /docker-entrypoint-initdb.d/
CMD ["--default-authentication-plugin=mysql_native_password"]