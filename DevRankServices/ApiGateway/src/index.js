import app from "./app.js";
import { PORT } from "./config.js";

function main() {
  app.listen(PORT, () => {
    console.log(`>>>>> Server is running on port ${PORT}`);
  });
}

main();
