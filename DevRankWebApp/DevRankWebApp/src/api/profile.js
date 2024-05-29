import axios from "./axios";

const API_URL = "/usersService/profile";

export const updateProfileRequest = (data) =>
  axios.patch(`${API_URL}/update`, data);
