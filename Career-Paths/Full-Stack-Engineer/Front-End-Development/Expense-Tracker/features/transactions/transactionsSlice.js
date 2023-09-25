import {createSlice} from '@redux/toolkit';

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
const initialState = Object.fromEntries(
  CATEGORIES.map((category) => [category, []])
);

const transactionsSlice = createSlice({
  name: 'transactions',
  initialState: initialState,
  reducers: {
    addTransaction: () => {
      const category = action.payload.category;
      state[category].push(action.payload);
    },
    deleteTransaction: () => {
      const id = action.payload.id;
      const category = action.payload.category;
      state[category] = state[category].filter(transaction => transaction.id !== id)
    }
  },
});

export {addTransaction, deleteTransaction} from transactionsSlice.action;
export default transactionsSlice.reducer;
