**UI Testcases

TC ID: TC01**



&#x20;   	**Test Description:** Login with valid credentials



&#x09;**Steps:**  
	 1) Enter valid email and password
	 2) Click Login

  	**Expected Result:** User is redirected to dashboard successfully

  	**Priority:** High



**TC ID: TC02**



&#x20; 	**Test Description:** Login with invalid credentials.



&#x20;   	**Steps:**  
	 1) Enter valid email and invalid password
 	 2) Click Login

    	**Expected Result:** System displays error message: "These credentials do not match our records"

    	**Priority:** High



**TC ID: TC03**



&#x20;   	**Test Description:** Login with username field empty



&#x09;**Steps:**  

&#x09;1) Leaves username field empty and enter valid password

&#x09;2) Click Login



&#x09;**Expected Result:** System displays error message: "Please fill in this field"



&#x09;**Priority:** Medium



**TC ID: TC04**



&#x20;  	**Test Description:** Access dashboard without login.



&#x20;   	**Steps:**  

&#x09;1) Ensure user is not logged in

&#x09;2) Launch application

&#x09;3) Directly access URL: "http://localhost:8080/dashboard"



&#x09;**Expected Result:** System displays “404 Not Found” page indicating the requested resource cannot be found.



&#x09;**Priority:** Medium



**TC ID: TC05**



&#x20;  	**Test Description:** Verify that a new asset account can be successfully created with valid details.



&#x20;   	**Steps:**  
 	1) Launch the application and log in with valid credentials(Email and Password).
 	2) Navigate to the Accounts → Asset Account → Create Asset Account.
 	3) Enter a unique account name and account number and all the mandatory details. 

&#x20;	4) click Create Account.



&#x20;	**Expected Result:** A success message appears: "New account <Account Name> stored!" and the account is added to the list.

    	**Priority:** High



**TC ID: TC06**



&#x20;     	**Test Description:** Verify that creating an asset account with a duplicate account name or duplicate account number is not allowed.



&#x09;**Steps:**

&#x09;1) Launch the application and log in with valid credentials(Email and Password).

&#x09;2) Navigate to the Accounts → Asset Account → Create Asset Account.

&#x09;3) Enter an account name that already exists in the system.

&#x09;4) Enter an account number that already exists in the system.

&#x09;5) click Create Account.

&#x09;

&#x09;**Expected Result:**

&#x09;

&#x09;1) Error alert message appears "This account name is already in use."

&#x09;2) Error alert message appears "It looks like this account number is already in use."

&#x09;3) The account is not created.



&#x09;**Priority:** High



**TC ID: TC07**



&#x20;  	**Test Description:** Verify that an existing asset account can be successfully deleted.

&#x09;

&#x20;   	**Steps:**  
 	1) Launch the application and log in with valid credentials(Email and Password).
 	2) Navigate to the Accounts  → Asset Account Page → select an existing account → click Actions → Delete.
 	3) confirm Deletion by clicking delete permanently option.

   	**Expected Result:**  Success alert message appears: Successfully deleted asset account "<Account Name>".

  	**Priority:**  High





**TC ID: TC08**



&#x20;  	**Test Description:** Verify that a new transaction can be successfully created with valid details.



&#x09;**Steps:**

&#x09;1) Launch the application and log in with valid credentials (Username and Password).

&#x09;2) Navigate to the Transaction → Expenses → Create new transaction.

&#x09;3) Enter valid transaction details (Source Account, Destination Account, Category, Amount, Description).

&#x09;4) click submit to Save Transaction.



&#x09;**Expected Result:** A success message appears: "Successfully created new transaction <Description>" and the transaction is added to the list.



&#x09;**Priority:** High



**TC ID: TC09**



&#x20;  	**Test Description:** Verify that creating a transaction with an invalid amount is not allowed.



&#x09;**Steps:**

&#x09;1) Launch the application and log in with valid credentials (Username and Password).

&#x09;2) Navigate to the Transaction → Expenses → Create new transaction.

&#x09;3) Enter valid description, source account, destination account and category details.

&#x09;4) Enter an invalid amount(e.g: -50).

&#x09;5) click submit to Save Transaction.



&#x09;**Expected Result:** Error message appears "The value must be more than zero." and the transaction is not created.



&#x09;**Priority:** High



**TC ID: TC10**



&#x20;  	**Test Description:** Verify that creating a transaction without selecting an account is not allowed.



&#x09;**Steps:**

&#x09;1) Launch the application and log in with valid credentials (Username and Password).

&#x09;2) Navigate to the Transaction → Expenses → Create new transaction.

&#x09;3) Leave the source account field blank.

&#x09;4) Enter valid category, amount, destination account and description details.

&#x09;5) click submit to Save Transaction.

&#x09;

&#x09;**Expected Result:** Error message appears: "Please select or type a valid source account name" and the transaction is not created.



&#x09;**Priority:** High



**TC ID: TC11**



&#x20;  	**Test Description:** Verify that creating a transaction with amount = 0 is not allowed.



&#x09;**Steps:**

&#x09;1) Launch the application and log in with valid credentials (Username and Password).

&#x09;2) Navigate to the Transaction → Expenses → Create new transaction.

&#x09;3) Enter valid description, source account, destination account and category details.

&#x09;4) Enter amount=0;

&#x09;5) click submit to Save Transaction.



&#x09;**Expected Result:** Error message appears "The value must be more than zero." and the transaction is not created.



&#x09;**Priority:** High.



**TC ID: TC12**



&#x20;  	**Test Description:** Verify that an existing transaction can be successfully deleted.



&#x09;**Steps:**

&#x09;1) Launch the application and log in with valid credentials (Username and Password).

&#x09;2) Navigate to the Transaction → Transfers → select an existing transaction → click Actions → Delete.

&#x09;3) confirm Deletion by clicking delete permanently option.



&#x09;**Expected Result:** A success message appears: "Successfully deleted transfer <Description>" and the transaction is removed from the list.



&#x09;**Priority:** High





**API Testcases

TC ID: TC01**



&#x20;  	**Test Description:** Verify that fetching a user by ID returns correct details.



&#x09;**Precondition:** User with ID = 1 exists in the system.

&#x20;

&#x09;**Steps:**	

&#x09;1) Send a GET request to /users/1.

&#x09;2) Observe the response.

&#x09;

&#x09;**Expected Result:**

&#x09;1) Status code = 200.

&#x09;2) Response body contains user details with "id = 1".

&#x09;3) username field should equal "Bret".



&#x09;**Priority:** High



**TC ID: TC02**



&#x20;  	**Test Description:** Verify that creating a post without a title field still returns success.



&#x09;**Precondition:** API is available.



&#x09;**Steps:** 

&#x09;1) Send a POST request with JSON body missing the "title" field.

&#x09;2) Observe the response.


&#x09;**Expected Result:**

&#x09;1) Status code = 201.

&#x09;2) Response body should contain title = null or missing.

&#x09;3) Other fields (body, userId) should be present.



&#x09;**Priority:** Medium



**TC ID: TC03**



&#x20;  	**Test Description:** Verify that fetching comments for a valid post returns correct details.



&#x09;**Precondition:** Post with ID = 1 exists.



&#x09;**Steps:** 

&#x09;1) Send a GET request to /posts/1/comments.

&#x09;2) Observe the response.



&#x09;**Expected Result:**

&#x09;1) Status code = 200.

&#x09;2) Response body contains a list of comments.

&#x09;3) Each comment should have postId = 1.

&#x09;4) email field in comments should not be null.



&#x09;**Priority:** High



**TC ID: TC04**



&#x20;  	**Test Description:** Verify that fetching comments for a non-existent post returns an empty array.



&#x09;**Precondition:** Post ID does not exist.

&#x09;

&#x09;**Steps:** 

&#x09;1) Send a GET request to /posts/99999/comments.

&#x09;2) Observe the response.



&#x09;**Expected Result:**

&#x09;1) Status code = 200.

&#x09;2) Response body should be an empty array \[].



&#x09;**Priority:** Medium

