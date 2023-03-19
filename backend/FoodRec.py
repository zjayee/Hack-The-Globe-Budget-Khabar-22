# Import the CSV file as a pandas DataFrame
import pandas as pd
grocery_df = pd.read_csv('grocery_database.csv')

# Prompt the user for their budget and the number of meals they want
total_budget = float(input("What is your total budget? "))
num_meals = int(input("How many meals do you want to prepare? "))
budget_per_meal = total_budget / num_meals

# Create an empty shopping cart dictionary
shopping_cart = {}

# Loop through each category
for category in grocery_df['Category'].unique():
    
    # Filter the DataFrame for the current category
    category_df = grocery_df[grocery_df['Category'] == category]
    
    # Sort the DataFrame by price per meal in ascending order
    category_df = category_df.sort_values(by='PricePerMeal')
    
    # Recommend 3 grocery items per category based on the user's budget
    recommended_df = category_df[category_df['PricePerMeal'] <= budget_per_meal].head(3)
    
    # Calculate the recommended quantity to purchase based on the number of meals
    recommended_df['QuantityToPurchase'] = ((num_meals / recommended_df['NumberOfMeals']).apply(round)).apply(int)
    
    # Check if the DataFrame is empty, if not, print the category
    if (not recommended_df.empty) & (recommended_df['QuantityToPurchase'].iloc[0] > 0):
        print("Category: ", category)
        print(recommended_df[['Food', 'Price', 'PricePerMeal', 'NumberOfMeals','QuantityToPurchase']])

        # Ask the user to select items from each food category
        while True:
            selected_item = input("Please type in one food item from the category you'd like to purchase (or type 'quit' to stop): ")
            
            # Check if the user wants to quit
            if selected_item.lower() == "quit":
                break
            
            # Check if the selected item is in the recommended list
            if selected_item not in recommended_df['Food'].values:
                print("The item you selected is not in the recommended list. Please try again.")
                continue
            
            # Get the recommended range of quantity for the selected item
            recommended_quantity = recommended_df.loc[recommended_df['Food'] == selected_item, 'QuantityToPurchase'].iloc[0]
            print(f"The recommended range of quantity to purchase for {selected_item} is between 0 and {recommended_quantity}.")
            
            # Ask the user to specify the quantity they want to purchase
            while True:
                quantity_to_purchase = input("How many would you like to purchase? ")
                
                # Check if the quantity is valid
                try:
                    quantity_to_purchase = int(quantity_to_purchase)
                except ValueError:
                    print("Please enter a valid number.")
                    continue
                
                if quantity_to_purchase < 0:
                    print("Please enter a non-negative quantity.")
                    continue
                
                if quantity_to_purchase > recommended_quantity:
                    print("The quantity you selected is above the recommended range. Please try again.")
                    continue

                break
                
            # If the quantity is valid, add the selected item and quantity to the cart
            if category not in shopping_cart:
                shopping_cart[category] = {}
            shopping_cart[category][selected_item] = quantity_to_purchase
            print(f"{quantity_to_purchase} {selected_item} added to the cart.")
                
            # If the user wants to quit, break out of the loop
            if selected_item.lower() == "quit":
                break

        
        # # Ask the user to select items from each food category
        # selected_item = input("Please type in one food item from the category you'd like to purchase: ")
        # quantity_to_purchase = int(input("How many " + selected_item + " would you like to purchase? "))

        # # if the user enters an invalid item, ask them to try again
        # while selected_item not in recommended_df['Food'].values:
        #     print("The item you selected is not in the recommended list. Please try again.")
        #     selected_item = input("Please type in one food item from the category you'd like to purchase: ")
        #     quantity_to_purchase = int(input("How many " + selected_item + " would you like to purchase? "))
        
        # # if the user enters an invalid quantity, ask them to try again, accept 0 as a valid quantity
        # while (quantity_to_purchase < 0) | (quantity_to_purchase > recommended_df['QuantityToPurchase'].iloc[0]):
        #     print("The quantity you selected is not in the recommended range. Please try again.")
        #     selected_item = input("Please type in one food item from the category you'd like to purchase: ")
        #     quantity_to_purchase = int(input("How many " + selected_item + " would you like to purchase? "))

        # # Add the selected item to the shopping cart
        # if category not in shopping_cart:
        #     shopping_cart[category] = {}
        # shopping_cart[category][selected_item] = quantity_to_purchase



# Calculate the total price of the items in the shopping cart
def calculate_total_price(shopping_cart, grocery_df):
    total_price = 0
    for category in shopping_cart:
        for item in shopping_cart[category]:
            quantity = shopping_cart[category][item]
            price = int(grocery_df[(grocery_df['Category'] == category) & (grocery_df['Food'] == item)]['Price'].iloc[0])
            total_price += quantity * price
    return total_price

# Check if the total price is within the user's total budget
total_price = calculate_total_price(shopping_cart, grocery_df)
if total_price <= total_budget:
    # Print the final shopping cart contents
    print("Shopping Cart:", shopping_cart)
    # Print the total price
    print("Total Price: ", total_price)
else:
    print("The total price of the shopping cart exceeds your budget. Please try again.")
