import { Router } from "express";
import { authRequired } from "../middlewares/validateToken.js";
import { profile, updateProfile } from "../controllers/profile.controller.js";
import upload from "../middlewares/multerConfig.js";

const router = Router();

router.get("/profile", authRequired, profile).patch(
  "/update",
  authRequired,
  /*
    upload.single("profileImage"),*/ updateProfile
);

export default router;
