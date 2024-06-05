import { Router } from "express";
import userService from "../services/users.service.js";
import challengesService from "../services/challenges.service.js";

const router = Router();

router.use("/users", userService);
router.use("/challenges", challengesService);

export default router;
