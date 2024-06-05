import "dotenv/config";

export const PORT = process.env.PORT || 3000;
export const USERSSERVICE_URL =
  process.env.USERSSERVICE_URL || "http://localhost:3001";
export const CHALLENGESSERVICE_URL =
  process.env.CHALLENGESSERVICE_URL || "http://localhost:3002";
