import { ModeToggle } from "./mode-toggle";
import { Link } from "react-router-dom";
import { useAuth } from "@/context/AuthContext";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu";
import { useTheme } from "./theme-provider";

export default function Navbar() {
  const { logout } = useAuth();
  const { setTheme } = useTheme();
  return (
    <nav className="fixed w-full h-16 top-0 flex justify-between bg-transparent backdrop-blur z-[1000] border-b p-5">
      <div className="flex gap-x-2 items-center">
        <Link to="/home">
          <h1 className=" text-3xl font-bold">DevRank</h1>
        </Link>
      </div>

      <div className="flex gap-x-8 items-center">
        <Link
          to="/home"
          className="icon-[mdi--home] text-3xl hover:text-secondary"
        ></Link>
        <Link
          to="/offers"
          className="icon-[mdi--briefcase] text-2xl hover:text-secondary"
        ></Link>
        <Link
          to="/challenges"
          className="icon-[mdi--terminal] text-2xl hover:text-secondary"
        ></Link>
        <Link
          to="/leaderboard"
          className="icon-[mdi--trophy] text-2xl hover:text-secondary"
        ></Link>
      </div>
      <div className="flex gap-x-8 items-center">
        <DropdownMenu>
          <DropdownMenuTrigger>
            <Avatar>
              <AvatarImage src="https://github.com/shadcn.png" />
              <AvatarFallback>CN</AvatarFallback>
            </Avatar>
          </DropdownMenuTrigger>
          <DropdownMenuContent>
            <DropdownMenuLabel>My Account</DropdownMenuLabel>
            <DropdownMenuSeparator />
            <DropdownMenuItem>
              <Link to="/profile">Profile</Link>
            </DropdownMenuItem>
            <DropdownMenuItem>
              <Link to="/settings">Settings</Link>
            </DropdownMenuItem>
            <DropdownMenuItem>
              <Link to="/*" onClick={logout}>
                Log out
              </Link>
            </DropdownMenuItem>
          </DropdownMenuContent>
        </DropdownMenu>
        <ModeToggle />
      </div>
    </nav>
  );
}
