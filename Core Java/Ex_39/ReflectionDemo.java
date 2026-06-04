package Ex_39;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      Java Reflection API Demo        ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        try {

            // ─────────────────────────────────────────
            // STEP 1 — Load class using Class.forName()
            // ─────────────────────────────────────────
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("STEP 1: Load Class using Class.forName()");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            Class<?> clazz = Class.forName("Ex_39.TargetClass");

            System.out.println("✅ Class loaded    : "
                    + clazz.getName());
            System.out.println("📦 Package         : "
                    + clazz.getPackageName());
            System.out.println("🔑 Simple Name     : "
                    + clazz.getSimpleName());
            System.out.println("🔒 Modifier        : "
                    + Modifier.toString(clazz.getModifiers()));
            System.out.println("👆 Superclass      : "
                    + clazz.getSuperclass().getName());

            // ─────────────────────────────────────────
            // STEP 2 — Get ALL Methods
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("STEP 2: getDeclaredMethods()");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("📋 Total methods found: "
                    + methods.length + "\n");

            for (Method method : methods) {
                System.out.println("  🔹 Method   : "
                        + method.getName());
                System.out.println("     Modifier : "
                        + Modifier.toString(
                            method.getModifiers()));
                System.out.println("     Returns  : "
                        + method.getReturnType()
                                 .getSimpleName());

                // Print parameters
                Class<?>[] params = method.getParameterTypes();
                if (params.length == 0) {
                    System.out.println("     Params   : none");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < params.length; i++) {
                        sb.append(params[i].getSimpleName());
                        if (i < params.length - 1)
                            sb.append(", ");
                    }
                    System.out.println("     Params   : "
                            + sb);
                }
                System.out.println();
            }

            // ─────────────────────────────────────────
            // STEP 3 — Get Constructors
            // ─────────────────────────────────────────
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("STEP 3: getConstructors()");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            Constructor<?>[] constructors =
                    clazz.getDeclaredConstructors();
            System.out.println("📋 Total constructors: "
                    + constructors.length + "\n");

            for (Constructor<?> c : constructors) {
                System.out.println("  🔹 Constructor : "
                        + c.getName());
                Class<?>[] cParams = c.getParameterTypes();
                if (cParams.length == 0) {
                    System.out.println("     Params     : none");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < cParams.length; i++) {
                        sb.append(cParams[i].getSimpleName());
                        if (i < cParams.length - 1)
                            sb.append(", ");
                    }
                    System.out.println("     Params     : " + sb);
                }
                System.out.println();
            }

            // ─────────────────────────────────────────
            // STEP 4 — Get Fields
            // ─────────────────────────────────────────
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("STEP 4: getDeclaredFields()");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            Field[] fields = clazz.getDeclaredFields();
            System.out.println("📋 Total fields: "
                    + fields.length + "\n");

            for (Field field : fields) {
                System.out.println("  🔹 Field    : "
                        + field.getName());
                System.out.println("     Type     : "
                        + field.getType().getSimpleName());
                System.out.println("     Modifier : "
                        + Modifier.toString(
                            field.getModifiers()));
                System.out.println();
            }

            // ─────────────────────────────────────────
            // STEP 5 — Create instance dynamically
            // ─────────────────────────────────────────
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("STEP 5: Create Instance Dynamically");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            // Using constructor with parameters
            Constructor<?> constructor =
                    clazz.getDeclaredConstructor(
                            String.class, int.class);
            Object obj = constructor.newInstance("Alice", 25);
            System.out.println("✅ Instance created : " + obj);

            // ─────────────────────────────────────────
            // STEP 6 — Invoke PUBLIC methods
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("STEP 6: invoke() — Public Methods");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            // Invoke greet()
            Method greetMethod =
                    clazz.getDeclaredMethod("greet");
            Object greetResult = greetMethod.invoke(obj);
            System.out.println("✅ greet()          : "
                    + greetResult);

            // Invoke add(int, int)
            Method addMethod =
                    clazz.getDeclaredMethod(
                            "add", int.class, int.class);
            Object addResult = addMethod.invoke(obj, 10, 20);
            System.out.println("✅ add(10, 20)      : "
                    + addResult);

            // Invoke sayHello(String)
            Method helloMethod =
                    clazz.getDeclaredMethod(
                            "sayHello", String.class);
            Object helloResult =
                    helloMethod.invoke(obj, "Bob");
            System.out.println("✅ sayHello(Bob)    : "
                    + helloResult);

            // Invoke static getCount()
            Method countMethod =
                    clazz.getDeclaredMethod("getCount");
            Object countResult = countMethod.invoke(null);
            System.out.println("✅ getCount()       : "
                    + countResult);

            // ─────────────────────────────────────────
            // STEP 7 — Invoke PRIVATE methods
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("STEP 7: invoke() — Private Methods");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            // Access private getSecret()
            Method secretMethod =
                    clazz.getDeclaredMethod("getSecret");
            secretMethod.setAccessible(true); // ← KEY LINE!
            Object secretResult = secretMethod.invoke(obj);
            System.out.println("✅ getSecret()      : "
                    + secretResult);

            // Access private multiply(int, int)
            Method multiplyMethod =
                    clazz.getDeclaredMethod(
                            "multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            Object multiplyResult =
                    multiplyMethod.invoke(obj, 6, 7);
            System.out.println("✅ multiply(6,7)    : "
                    + multiplyResult);

            // ─────────────────────────────────────────
            // STEP 8 — Access & Modify PRIVATE fields
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("STEP 8: Access & Modify Private Fields");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            // Read private field
            Field nameField =
                    clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            System.out.println("✅ name (before)    : "
                    + nameField.get(obj));

            // Modify private field
            nameField.set(obj, "Bob Modified");
            System.out.println("✅ name (after)     : "
                    + nameField.get(obj));

            // Read private int field
            Field ageField =
                    clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            System.out.println("✅ age (before)     : "
                    + ageField.get(obj));
            ageField.set(obj, 99);
            System.out.println("✅ age (after)      : "
                    + ageField.get(obj));

            System.out.println("\n✅ Updated object   : " + obj);

            // ─────────────────────────────────────────
            // SUMMARY
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("SUMMARY: Reflection API Methods Used");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  Class.forName()          → load class");
            System.out.println("  getDeclaredMethods()     → get methods");
            System.out.println("  getDeclaredFields()      → get fields");
            System.out.println("  getDeclaredConstructors()→ get constructors");
            System.out.println("  getDeclaredMethod(name)  → get one method");
            System.out.println("  method.invoke(obj, args) → call method");
            System.out.println("  setAccessible(true)      → access private");
            System.out.println("  field.get(obj)           → read field");
            System.out.println("  field.set(obj, value)    → modify field");
            System.out.println("  constructor.newInstance()→ create object");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Class not found : "
                    + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}