import codecademylib3
import pandas as pd

ad_clicks = pd.read_csv('ad_clicks.csv')

# Step 1
print(ad_clicks.head(5))

# Step 2
print(ad_clicks.groupby('utm_source')\
    .user_id.count()\
    .reset_index())

# Step 3
ad_clicks['is_click'] = ~ad_clicks.ad_click_timestamp.isnull()

# Step 4
clicks_by_source = ad_clicks.groupby(['utm_source', 'is_click']).user_id.count().reset_index()

# Step 5
clicks_pivot = clicks_by_source\
   .pivot(index='utm_source',
          columns='is_click',
          values='user_id')\
   .reset_index()

# Step 6
clicks_pivot['percent_clicked'] = clicks_pivot[True] / (clicks_pivot[True] + clicks_pivot[False])

# Step 7
AB_views = ad_clicks.groupby('experimental_group').user_id.count().reset_index()
print(AB_views)

# Step 8
AB_clickrate = ad_clicks.groupby(['experimental_group', 'is_click']).user_id.count().reset_index().pivot(index='is_click', columns='experimental_group', values='user_id')
print(AB_clickrate)

# Step 9
a_clicks = ad_clicks[ad_clicks.experimental_group == 'A']
b_clicks = ad_clicks[ad_clicks.experimental_group == 'B']

# Step 10
a_clicks_percentages = a_clicks.groupby(['is_click', 'day']).user_id.count().reset_index().pivot(index='day', columns='is_click', values='user_id')
a_clicks_percentages['percent_clicked'] = a_clicks_percentages[True] / (a_clicks_percentages[True] + a_clicks_percentages[False])

b_clicks_percentages = b_clicks.groupby(['is_click', 'day']).user_id.count().reset_index().pivot(index='day', columns='is_click', values='user_id')
b_clicks_percentages['percent_clicked'] = b_clicks_percentages[True] / (b_clicks_percentages[True] + b_clicks_percentages[False])

print(a_clicks_percentages)
print(b_clicks_percentages)