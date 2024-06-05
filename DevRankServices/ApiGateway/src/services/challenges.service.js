import { Router } from "express";
import { createProxyMiddleware } from "http-proxy-middleware";
import { CHALLENGESSERVICE_URL } from "../config.js";

const router = Router();

const challengesServiceProxy = createProxyMiddleware({
  target: CHALLENGESSERVICE_URL,
  changeOrigin: true,
  pathRewrite: { "^/api/challenges": "/challenges" },
});

router.use("/", challengesServiceProxy);

export default router;
