import axios from "./axios";

const API_URL = "/usersService/auth";

export const registerRequest = (user) =>
  axios.post(`${API_URL}/register`, user);

export const loginRequest = (user) => axios.post(`${API_URL}/login`, user);

export const logoutRequest = () => axios.post(`${API_URL}/logout`);

export const verifyRequest = () => axios.get(`${API_URL}/verify`);
