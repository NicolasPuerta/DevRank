import { Button } from "@/components/ui/button";
import { Textarea } from "@/components/ui/textarea";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
  DialogFooter,
  DialogClose,
} from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useForm } from "react-hook-form";

export default function DinamicDialogForm({ fields, label, onSubmitHandler }) {
  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => {
    onSubmitHandler(data);
    reset();
  };

  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button variant="outline">{label}</Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>{label}</DialogTitle>
        </DialogHeader>
        <form onSubmit={handleSubmit(onSubmit)} form={label + "-form"}>
          {fields.map(({ name, label, type, validation }) => (
            <div key={name} className="my-4">
              <Label htmlFor={name}>{label}</Label>
              {errors[name] && (
                <DialogDescription className="text-destructive my-1">
                  {label} is required
                </DialogDescription>
              )}
              {type === "textarea" ? (
                <Textarea
                  id={name}
                  className="bg-secondary"
                  {...register(name, validation)}
                />
              ) : (
                <Input
                  id={name}
                  className="bg-secondary"
                  type={type}
                  {...register(name, validation)}
                  onChange={(e) => {
                    console.log(e.target.value);
                  }}
                />
              )}
            </div>
          ))}
          <DialogFooter className="mt-6">
            <DialogClose>
              <Button type="submit">Save</Button>
            </DialogClose>
          </DialogFooter>
        </form>
      </DialogContent>
    </Dialog>
  );
}
