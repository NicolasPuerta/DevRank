import jwt from "jsonwebtoken";
import { TOKEN_SECRET } from "../config.js";

export const authRequired = (req, res, next) => {
  const token = req.header.Authorization;
  if (!token)
    return res.status(401).json({ message: "Not token, authorization denied" });

  jwt.verify(token, TOKEN_SECRET, (err, decoded) => {
    if (err) return res.status(401).json({ message: "Invalid token" });

    req.dev = decoded;
    next();
  });
};
