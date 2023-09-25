import {createSlice} from '@reduxjs/toolkit'

export const CATEGORIES = [
  "housing",
  "food",
  "transportation",
  "utilities",
  "clothing",
  "healthcare",
  "personal",
  "education",
  "entertainment",
];
const initialState = CATEGORIES.map((category) => ({
  category: category,
  amount: 0,
}));

const budgetsSlice = createSlice({
  name: 'budgets',
  initialState: initialState,
  reducers: {
    editBudget: (state, action) => {
      const category = action.payload.category;
      const amount = action.payload.amount;
      state.find(budget => budget.category === category).amount = amount
    }
  },
})

export const {editBudget} = budgetsSlice.actions;
export default budgetsSlice.reducer;
