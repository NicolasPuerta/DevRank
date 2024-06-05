import { Router } from "express";
import {
  getChallenges,
  getChallengeById,
  createChallenge,
} from "../controllers/challenges.controller.js";

const router = Router();

router
  .get("/", getChallenges)
  .get("/:id", getChallengeById)
  .post("/challenge", createChallenge);

export default router;
