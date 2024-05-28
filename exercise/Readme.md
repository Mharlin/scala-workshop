
## Exercise part 1
- Load the project in folder `exercise` and run the tests
- Fulfill the tests by implement the parsing of a CSV string "Magnus H, 38" should produce an instance of the User class.
- Make sure that the implementation can also handle empty age or invalid numbers in the age field.

## Exercise part 2
- Create a Order class that has a list of Products.
- Create a Product class that has: Name, Price, Category.
- Add a list of orders to the User.
- If a user has order value that is above 1000 it should be a VIP user (See the commented out tests for inspiration).

## Exercise part 2.5
- If the user is a VIP user it should get 10% discount on the order value.
- Create two types of users: `Customer` and `Nerd`.
- The Nerd gets an additional 15% discount if the product category is Tech.
- When doing a checkout calculate: total amount, discount, amount per category, discount per category.
