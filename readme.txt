New version version with web socket !

GET http://localhost:8095/news  list
GET http://localhost:8095/news/map  map clef = id
GET http://localhost:8095/news/425a314c-23f7-4d83-84f7-cdd0a0a55c10  : get
PUT http://localhost:8095/news/425a314c-23f7-4d83-84f7-cdd0a0a55c10  : update
DELETE http://localhost:8095/news/425a314c-23f7-4d83-84f7-cdd0a0a55c10  : delete
POST http://localhost:8095/news  create

Web Socket : http://localhost:8095/news-websocket  /topic/news

Default page display news event – create - update (every 2 sec) : http://localhost:8095
GET http://localhost:8095/news/reload : reload data from start
POST http://localhost:8095/news/reload : reload data from start

Click HERE to download  ipush-demo-with-websocket.zip

Start command line : java -jar  demo-0.0.1-SNAPSHOT.jar  --server.port=8095 --import.duration=2000

import.duration : first import element frenquency
server.port : port override default 8095
