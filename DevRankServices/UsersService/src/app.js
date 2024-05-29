import express from "express";
import morgan from "morgan";
import cors from "cors";
import fileUpload from "express-fileupload";

import authRoutes from "./routes/auth.routes.js";
import profileRoutes from "./routes/profile.routes.js";

const app = express();

app.use(
  cors({
    origin: "http://127.0.0.1:5173",
    credentials: true,
  })
);
app.use(morgan("dev"));
app.use(express.json());
app.use(
  fileUpload({
    useTempFiles: true,
    tempFileDir: "/uploads/profileImages",
  })
);

app.use("/api/usersService/auth", authRoutes);
app.use("/api/usersService/profile", profileRoutes);

export default app;
