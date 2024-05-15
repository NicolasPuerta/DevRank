import { Router } from "express";
import {
  register,
  login,
  logout,
  profile,
} from "../controllers/auth.controller.js";
import { authRequired } from "../middlewares/validateToken.js";

const router = Router();

router
  .post("/register", register)
  .post("/login", login)
  .post("/logout", logout)
  .get("/profile", authRequired, profile);

export default router;
