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
    
    # Print the recommended grocery items and prompt the user to add to the shopping cart
    print("Category: ", category)
    print(recommended_df[['Food', 'Price', 'PricePerMeal', 'QuantityToPurchase']])
    for index, row in recommended_df.iterrows():
        response = input("Would you like to add " + row['Food'] + " to your shopping cart? (Y/N) ")
        if response.upper() == 'Y':
            if category not in shopping_cart:
                shopping_cart[category] = {}
            shopping_cart[category][row['Food']] = row['QuantityToPurchase']


# Print the final shopping cart contents
print("Shopping Cart:")
print(shopping_cart)

# Calculate the total price of the items in the shopping cart
def calculate_total_price(shopping_cart, grocery_df):
    total_price = 0
    for category in shopping_cart:
        for item in shopping_cart[category]:
            quantity = shopping_cart[category][item]
            price = int(grocery_df[(grocery_df['Category'] == category) & (grocery_df['Food'] == item)]['Price'].iloc[0])
            total_price += quantity * price
    return total_price


# Print the total price
print("Total Price: ", calculate_total_price(shopping_cart, grocery_df))


# Check if the user is meeting the requirements for every category
for category in grocery_df['Category'].unique():
    
    # Filter the DataFrame for the current category
    category_df = grocery_df[grocery_df['Category'] == category]
    
    # Calculate the total quantity required for the number of meals
    total_quantity_required = ((num_meals / category_df['NumberOfMeals']).apply(round)).apply(int).sum()
    
    # Check if the user has met the requirements for this category
    if category in shopping_cart:
        total_quantity_purchased = sum(shopping_cart[category].values())
        if total_quantity_purchased < total_quantity_required:
            print("Select more items for", category, "to meet your number of meals")
            response = input("Would you like to add more items to your shopping cart? (Y/N) ")
            if response.upper() == 'Y':
                # Recommend additional items and prompt the user to add to the shopping cart
                additional_df = category_df[category_df['PricePerMeal'] > budget_per_meal].head(3)
                additional_df['QuantityToPurchase'] = ((num_meals / additional_df['NumberOfMeals']).apply(round)).apply(int)
                print(additional_df[['Food', 'Price', 'PricePerMeal', 'QuantityToPurchase']])
                for index, row in additional_df.iterrows():
                    response = input("Would you like to add " + row['Food'] + " to your shopping cart? (Y/N) ")
                    if response.upper() == 'Y':
                        if category not in shopping_cart:
                            shopping_cart[category] = {}
                        shopping_cart[category][row['Food']] = row['QuantityToPurchase']
