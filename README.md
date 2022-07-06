<h2>:superhero:DEFENDERS MANAGEMENT API</h2>

<b>About:</b><br/>
Defenders is a Marvel superhero team, made with chaotic people dealing with their over the top superpowers.<br/>
This is an API management for getting and inputing data on them.

<b>Structure pattern:</b><br/>
Hexagonal

<b>Technologies:</b><br/>
Kotlin, Spring, PostgreSQL, Heroku Deploy

<b>Setting the project up:</b><br/>
- For local build, the _.env_ file on the _docker_ folder has the data which must be set as Environment Variabes.<br/>
- After it, build the yaml inside the folder using the docker compose to have access to PostgreSQL 

<b>Using Docker:</b><br/>
docker-compose -f defender-api-resources.yaml up -d <br/>
docker-compose -f defender-api-resources.yaml down

<b>Swagger Documentation on localhost:</b><br/>
http://localhost:9090/defenders/swagger-ui.html

<b>Swagger Documentation on web:</b><br/>
https://defenders-management-api.herokuapp.com/defenders/swagger-ui.html