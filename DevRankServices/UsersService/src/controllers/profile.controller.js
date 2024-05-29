import Developer from "../models/dev.model.js";

export const profile = async (req, res) => {
  try {
    const devFound = await Developer.findById(req.dev.id);

    if (!devFound) return res.status(400).json({ message: "User not found" });

    res.json({
      id: devFound._id,
      userName: devFound.userName,
      name: devFound.name,
      lastName: devFound.lastName,
      email: devFound.email,
      about: devFound.about,
      profileImage: devFound.profileImage,
      documents: devFound.documents,
      experience: devFound.experience,
      education: devFound.education,
      skills: devFound.skills,
      socialLinks: devFound.socialLinks,
      createdAt: devFound.createdAt,
      updatedAt: devFound.updatedAt,
      token: token,
    });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

export const updateProfile = async (req, res) => {
  const { id, data } = req.body;

  console.log("file: ", req.files.profileImage);

  try {
    const updateData = { ...data };

    if (req.file) {
      updateData.profileImage = req.file.path;
    }

    const devUpdated = await Developer.findByIdAndUpdate(id, updateData, {
      new: true,
    });

    if (!devUpdated) return res.status(400).json({ message: "User not found" });

    console.log(devUpdated);
    res.json({
      id: devUpdated._id,
      userName: devUpdated.userName,
      name: devUpdated.name,
      lastName: devUpdated.lastName,
      email: devUpdated.email,
      about: devUpdated.about,
      profileImage: devUpdated.profileImage,
      documents: devUpdated.documents,
      experience: devUpdated.experience,
      education: devUpdated.education,
      skills: devUpdated.skills,
      socialLinks: devUpdated.socialLinks,
      createdAt: devUpdated.createdAt,
      updatedAt: devUpdated.updatedAt,
    });
  } catch (error) {
    console.log(error);
    res.status(500).json({ message: error.message });
  }
};
