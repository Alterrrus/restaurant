### curl samples (application deployed at application context `restaurant`).
> For windows use `Git Bash`

#### get All Users(Admin)
`curl -s http://localhost:8080/restaurant/rest/admin/users --user admin@gmail.com:admin`

#### get Users 100001 (Admin)
`curl -s http://localhost:8080/restaurant/rest/admin/users/10001 --user admin@gmail.com:admin`

#### register Users(Anonymous)
`curl -s -i -X POST -d '{"name":"New User","email":"test@mail.ru","password":"test-password"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/profile/register`

#### get Profile(User)
`curl -s http://localhost:8080/restaurant/rest/profile --user test@mail.ru:test-password`
#############################################

###AdminGetAllRestaurantWithDishAndVote(Admin)
`curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants --user admin@gmail.com:admin`

###addRestaurant(Admin)
`curl -s -i -X POST -d '{"name":"New Restaurant"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants --user admin@gmail.com:admin`
###getRestaurantDishes(Admin)
`curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants/10002/dishes --user admin@gmail.com:admin`
###addRestaurantDishes(Admin)
`curl -s -i -X POST -d '{"name":"New SoupCreate","price":"1000"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants/10002/dishes --user admin@gmail.com:admin`
###updateDishes(Admin)
`curl -s -i -X PUT -d '{"id":"10010","name":"Update Soupupdate","price":"1000"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants/10002/dishes/10010 --user admin@gmail.com:admin`
###getRestaurantDish(Admin)
`curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants/10002/dishes/10010 --user admin@gmail.com:admin`
###DeleteRestaurantDish(Admin)
`curl -s -X DELETE http://localhost:8080/restaurant/rest/admin/restaurants/10002/dishes/10009 --user admin@gmail.com:admin`

###getRestaurant(Admin)
`curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants/10002 --user admin@gmail.com:admin`
###updateRestaurant(Admin)
`curl -s -i -X PUT -d '{"id":"10002","name":"newЛасточка"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants/10002 --user admin@gmail.com:admin`
###getRestaurantVote(Admin)
`curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/admin/restaurants/10003/votes --user admin@gmail.com:admin`

###deleteUser (Admin)
`curl -s -X DELETE http://localhost:8080/restaurant/rest/admin/users/10017 --user admin@gmail.com:admin`

###addVote(User)
`curl -s -i -X PUT http://localhost:8080/restaurant/rest/restaurants/10002/votes --user user@gmail.com:user`
###getAllRestaurantVotes(User)
`curl -s -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/restaurant/rest/restaurants/10002/votes --user user@gmail.com:user`





