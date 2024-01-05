# bakery
This is the backend project of Bakery

In this assignment you are working as a team while using GitHub fundamentals and commands.

In this bakery there are five main classes as mentioned below
	Customer
	Category
	Item
	Order
	Order Item

The attributes are mentioned below.
	Customer
		First Name
		Last Name
		Email
		Contact Number
		Username
		Status (ACTIVE / INACTIVE)
		Created date
		Created user
		Modified date
		Modified user

	
	Category
		Name
		Code (unique, can not update)
		Description
		Image URL
		Status (AVAILABLE / NOT_AVAILABLE)
		Created date
		Created user
		Modified date
		Modified user


	Item
		Category Id (foreign key)
		Name
		Code (unique, can not update)
		Description
		Image URL
		Price
		Discount
		Sales Price
		Status (AVAILABLE / NOT_AVAILABLE)
		Created date
		Created user
		Modified date
		Modified user	

	Order
		Customer Id (foreign key)
		Reference Code (unique, can not update)
		Description
		Status (PENDING / CANCELLED / COMPLETED)
		Created date
		Created user
		Modified date
		Modified user

	Order Item
		Order Id (foreign key)
		Item Id
		Status (ACTIVE / INACTIVE)
		Created date
		Created user
		Modified date
		Modified user		


Customer can come to the bakery and order food from the bakery as you all are doing in real life
You have to create below APIs
			Customer
				Add new customer
				Get customer by username
				Get customer by id
				Get all customers
				Get customers by status
				Update customer
				Delete customer

			Category
				Add new category
				Get category by code
				Get category by id
				Get all categories
				Update category
				Delete category	

			Item
				Add new item
				Get item by code
				Get item by id
				Get item by category id
				Get all items
				Update item
				Delete item	

			Order
				Add new order
				Get order by reference code
				Get order by id
				Get order by customer id
				Get all orders
				Update order
				Delete order

			Order Item
				
				Order Item should be saved when creating orders	(list saving concept will be covered from KT Session)



