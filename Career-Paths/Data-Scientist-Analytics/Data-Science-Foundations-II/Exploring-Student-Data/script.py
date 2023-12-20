# Load libraries
import pandas as pd
import numpy as np
import codecademylib3
import matplotlib.pyplot as plt
import seaborn as sns

# Import data
students = pd.read_csv('students.csv')

# Print first few rows of data
print(students.head())
# Print summary statistics for all columns
print(students.describe())
# Calculate mean
mean = students.math_grade.mean()
print(mean)
# Calculate median
median = students.math_grade.median()
print(median)
# Calculate mode
mode = students.math_grade.mode()[0]
print(mode)
# Calculate range
range = students.math_grade.max() - students.math_grade.min()
print(range)
# Calculate standard deviation
std = students.math_grade.std()
print(std)
# Calculate MAD
mad = students.math_grade.mad()
print(mad)
# Create a histogram of math grades
sns.histplot(x='math_grade', data=students)

plt.show()
plt.clf()

# Create a box plot of math grades
sns.boxplot(x='math_grade', data=students)

plt.show()
plt.clf()

# Calculate number of students with mothers in each job category
mjobs = students.Mjob.value_counts()
print(mjobs)
# Calculate proportion of students with mothers in each job category
proportion = students.Mjob.value_counts(normalize=True)
print(proportion)
# Create bar chart of Mjob
sns.countplot(x='Mjob', data=students)

plt.show()
plt.clf()

# Create pie chart of Mjob
students.Mjob.value_counts().plot.pie()

plt.show()