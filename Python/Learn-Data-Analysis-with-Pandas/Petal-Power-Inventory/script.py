import pandas as pd

# Step 1
inventory = pd.DataFrame(pd.read_csv('inventory.csv'))
# Step 2
inventory.head(10)
# Step 3
staten_island = inventory.head(10)
# Step 4
product_request = staten_island['product_description']
# Step 5
seed_request = inventory[(inventory['location'] == 'Brooklyn') & (inventory['product_type'] == 'seeds')]
# Step 6
inventory['in_stock'] = inventory['quantity'].apply(lambda x: True if x > 0 else False)
# Step 7
inventory['total_value'] = inventory.price * inventory.quantity
# Step 8
combine_lambda = lambda row: \
    '{} - {}'.format(row.product_type,
                     row.product_description)
# Step 9
inventory['full_description'] = inventory.apply(combine_lambda, axis=1)