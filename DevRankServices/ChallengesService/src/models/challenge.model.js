import mongoose from "mongoose";

const challengeSchema = new mongoose.Schema(
  {
    title: { type: String, required: true },
    description: { type: String, required: true },
    difficulty: { type: String, required: true },
    color: { type: String, required: true },
    points: { type: Number, required: true },
    input: { type: String, required: true },
    output: { type: String, required: true },
    instructions: {
      description: { type: String, required: true },
      instructions: { type: String, required: true },
      example: { type: String, required: true },
      input: { type: String, required: true },
      output: { type: String, required: true },
    },
  },
  { timestamps: true }
);

export default mongoose.model("Challenge", challengeSchema);
