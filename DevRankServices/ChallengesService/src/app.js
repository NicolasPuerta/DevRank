import express from "express";
import morgan from "morgan";
import cors from "cors";

import challengesRoutes from "./routes/challenges.routes.js";

const app = express();

app.use(cors());
app.use(morgan("dev"));
app.use(express.json());

app.use("/api/challenges", challengesRoutes);

export default app;
