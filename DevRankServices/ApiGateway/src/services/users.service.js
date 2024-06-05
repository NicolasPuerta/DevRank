import { Router } from "express";
import { createProxyMiddleware } from "http-proxy-middleware";
import { USERSSERVICE_URL } from "../config.js";

const router = Router();

const usersServiceProxy = createProxyMiddleware({
  target: USERSSERVICE_URL,
  changeOrigin: true,
  pathRewrite: { "^/api/users/1": "/auth" },
  timeout: 5000,
});

router.use("/", usersServiceProxy);

export default router;
