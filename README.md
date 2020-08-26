# my-posts
## Installation and Execution
* git clone https://github.com/rowan1/my-posts.git
* cd my-posts
* Run maven project
* Go to this url: http://localhost:8080/swagger-ui.html
### For Authentication Endpoint
* Open Jwt Authentication Controller endpoints
* Post -> /authenticate with any user from Users test
* Copy the token you got from here.
* by click on the Authorize button paste token here by adding add Bearer ${token} in value text input then click authorize then click close.

### For the creation public or private post endpoint:
* Open post controller endpoints
* Enter any of post test data in post object

### Search for public posts by content text Endpoint
* Get /post/search
* Enter in field text what do you want to search for (multiple words)

## Test data:
### Users test:
Uer test
{
  "password": "ben",
  "username": "test"
}
User test_1
{
  "password": "ben",
  "username": "test_1"
}
User test_2
{
  "password": "ben",
  "username": "test_2"
}
### Posts test
For User test
{
  "content": "Hello this is Test user creating his first private post",
  "status": "PRIVATE" 
}
{
  "content": "Hello this is Test user creating his second private post",
  "status": "PRIVATE"
  
}
{
  "content": "Hello this is Test user creating his first public post",
  "status": "PUBLIC"
}
{
  "content": "Hello this is Test user creating his second public post",
  "status": "PUBLIC"
}
For User test_1
{
  "content": "Hello this is Test_1 user creating his first public post",
  "status": "PUBLIC"
}
{
  "content": "Hello this is Test_1 user creating his second public post",
  "status": "PUBLIC"
}
{
  "content": "Hello this is Test_1 user creating his first private post",
  "status": "PRIVATE"
}
{
  "content": "Hello this is Test_1 user creating his second private post",
  "status": "PRIVATE"
}
