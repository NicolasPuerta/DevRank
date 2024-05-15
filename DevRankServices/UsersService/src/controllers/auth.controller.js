import Developer from "../models/dev.model.js";
import bcrypt from "bcryptjs";
import { createAccessToken } from "../lib/jwt.js";

export const register = async (req, res) => {
  const { userName, name, lastName, email, password } = req.body;

  try {
    const paswordHash = await bcrypt.hash(password, 10);

    const newDev = new Developer({
      userName,
      name,
      lastName,
      email,
      password: paswordHash,
    });

    const devSaved = await newDev.save();
    const token = await createAccessToken({ id: devSaved._id });

    res.cookie("token", token, {
      httpOnly: true,
      sameSite: true,
    });
    res.json({
      id: devSaved._id,
      userName: devSaved.userName,
      name: devSaved.name,
      lastName: devSaved.lastName,
      email: devSaved.email,
      createdAt: devSaved.createdAt,
      updatedAt: devSaved.updatedAt,
    });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const login = async (req, res) => {
  const { userName, password } = req.body;

  try {
    const devFound = await Developer.findOne({ userName });

    if (!devFound) return res.status(400).json({ message: "User not found" });

    const passwordMach = await bcrypt.compare(password, devFound.password);

    if (!passwordMach)
      return res.status(401).json({ message: "Invalid password" });

    const token = await createAccessToken({ id: devFound._id });

    res.cookie("token", token, {
      httpOnly: true,
      sameSite: true,
    });
    res.json({
      id: devFound._id,
      userName: devFound.userName,
      name: devFound.name,
      lastName: devFound.lastName,
      email: devFound.email,
      createdAt: devFound.createdAt,
      updatedAt: devFound.updatedAt,
    });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const logout = (req, res) => {
  res.cookie("token", "", {
    expires: new Date(0),
  });
  return res.status(200);
};

export const profile = async (req, res) => {
  const devFound = await Developer.findById(req.dev.id);

  if (!devFound) return res.status(400).json({ message: "User not found" });

  res.json({
    id: devFound._id,
    userName: devFound.userName,
    name: devFound.name,
    lastName: devFound.lastName,
    email: devFound.email,
    createdAt: devFound.createdAt,
    updatedAt: devFound.updatedAt,
  });
};
