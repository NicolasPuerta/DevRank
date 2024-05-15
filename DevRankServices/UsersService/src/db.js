import mongoose from "mongoose";

export const connectDB = async () => {
  try {
    await mongoose.connect("mongodb://localhost:27017/usersService");
    console.log(">>>>> DB connected");
  } catch (error) {
    console.error(error);
  }
};
