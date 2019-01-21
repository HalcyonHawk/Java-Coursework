package bcu.grader.adventure;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.*;

/*
 *********************************************************************
 * To test your project, write your student ID number below, and run *
 * this class as a JUnit 4 test suite. If all tests pass, then your  *
 * project has the correct classes with the correct methods and      *
 * constructors, and they have the correct signatures. These tests   *
 * give no further guarantees about the correctness of your work.    *
 *********************************************************************
                                                                     */
public class ProjectStructureTest {
	// Write your student ID number here, beginning with a lowercase 's'.
	private static final String STUDENT_ID_NUMBER = "s17123433";
	
	/*
	 *********************************************
	 * Please ignore everything below this line. *
	 *********************************************
	                                             */
	
	@Test
	public void class_DoAction() {
		AssertClass clazz = cls("effects.DoAction")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor(String.class)
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_DropItem() {
		AssertClass clazz = cls("effects.DropItem")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor(String.class)
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void interface_Effect() {
		AssertClass clazz = cls("effects.Effect")
			.assertPublic()
			.assertIsInterface(true);
		clazz.assertMethod("execute")
			.assertReturns(void.class)
			.assertParameters(cls("model.Player").clazz, cls("model.World").clazz)
			.assertThrows();
	}
	
	@Test
	public void class_GoDirection() {
		AssertClass clazz = cls("effects.GoDirection")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor(String.class)
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_LookItem() {
		AssertClass clazz = cls("effects.LookItem")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor(String.class)
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_LookLocation() {
		AssertClass clazz = cls("effects.LookLocation")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor()
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_Message() {
		AssertClass clazz = cls("effects.Message")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor(String.class)
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_Quit() {
		AssertClass clazz = cls("effects.Quit")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor()
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_ShowInventory() {
		AssertClass clazz = cls("effects.ShowInventory")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor()
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_TakeItem() {
		AssertClass clazz = cls("effects.TakeItem")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(cls("effects.Effect").clazz);
		clazz.assertConstructor(String.class)
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_CommandParser() {
		AssertClass clazz = cls("game.CommandParser")
			.assertPublic();
		clazz.assertMethod("parsePlayerCommand")
			.assertPublic()
			.assertStatic(true)
			.assertAbstract(false)
			.assertReturns(cls("effects.Effect").clazz)
			.assertParameters(String.class)
			.assertThrows();
	}
	
	@Test
	public void class_Main() {
		AssertClass clazz = cls("game.Main")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertImplements(Runnable.class);
		clazz.assertConstructor(cls("model.World").clazz)
			.assertPublic()
			.assertThrows();
		clazz.assertMethod("main")
			.assertPublic()
			.assertStatic(true)
			.assertReturns(void.class)
			.assertParameters(String[].class)
			.assertThrows();
	}
	
	@Test
	public void class_QuitException() {
		AssertClass clazz = cls("game.QuitException")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false)
			.assertExtends(RuntimeException.class);
		clazz.assertConstructor()
			.assertPublic()
			.assertThrows();
	}
	
	@Test
	public void class_Action() {
		AssertClass clazz = cls("model.Action")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false);
		clazz.assertConstructor(String.class)
			.assertPublic()
			.assertThrows();
		clazz.assertMethod("getName")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(String.class)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("addRequiredItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("model.Item").clazz)
			.assertThrows();
		clazz.assertMethod("isAllowed")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(boolean.class)
			.assertParameters(cls("model.Player").clazz)
			.assertThrows();
		clazz.assertMethod("addEffect")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("effects.Effect").clazz)
			.assertThrows();
		clazz.assertMethod("getEffects")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(java.util.List.class)
			.assertReturnsTypeArguments(cls("effects.Effect").clazz)
			.assertParameters()
			.assertThrows();
	}
	
	@Test
	public void class_Item() {
		AssertClass clazz = cls("model.Item")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false);
		clazz.assertConstructor(String.class, String.class)
			.assertPublic()
			.assertThrows();
		clazz.assertMethod("getName")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(String.class)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("getDescription")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(String.class)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("isPortable")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(boolean.class)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("setPortable")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(boolean.class)
			.assertThrows();
		clazz.assertMethod("getLocation")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Location").clazz)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("setLocation")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("model.Location").clazz)
			.assertThrows();
	}
	
	@Test
	public void class_Location() {
		AssertClass clazz = cls("model.Location")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false);
		clazz.assertConstructor(String.class, String.class)
			.assertPublic()
			.assertThrows();
		clazz.assertMethod("getName")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(String.class)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("getDescription")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(String.class)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("addNeighbour")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(String.class, cls("model.Location").clazz)
			.assertThrows();
		clazz.assertMethod("getNeighbour")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Location").clazz)
			.assertParameters(String.class)
			.assertThrows();
		clazz.assertMethod("getAllDirections")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(java.util.Collection.class)
			.assertReturnsTypeArguments(String.class)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("getItems")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(java.util.List.class)
			.assertReturnsTypeArguments(cls("model.Item").clazz)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("addItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("model.Item").clazz)
			.assertThrows();
		clazz.assertMethod("hasItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(boolean.class)
			.assertParameters(cls("model.Item").clazz)
			.assertThrows();
		clazz.assertMethod("removeItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("model.Item").clazz)
			.assertThrows();
	}
	
	@Test
	public void class_Player() {
		AssertClass clazz = cls("model.Player")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false);
		clazz.assertConstructor(cls("model.Location").clazz)
			.assertPublic()
			.assertThrows();
		clazz.assertMethod("getLocation")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Location").clazz)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("setLocation")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("model.Location").clazz)
			.assertThrows();
		clazz.assertMethod("takeItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("model.Item").clazz)
			.assertThrows();
		clazz.assertMethod("hasItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(boolean.class)
			.assertParameters(cls("model.Item").clazz)
			.assertThrows();
		clazz.assertMethod("canSeeItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(boolean.class)
			.assertParameters(cls("model.Item").clazz)
			.assertThrows();
		clazz.assertMethod("dropItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("model.Item").clazz)
			.assertThrows();
		clazz.assertMethod("getInventory")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(java.util.List.class)
			.assertReturnsTypeArguments(cls("model.Item").clazz)
			.assertParameters()
			.assertThrows();
	}
	
	@Test
	public void class_World() {
		AssertClass clazz = cls("model.World")
			.assertPublic()
			.assertAbstract(false)
			.assertIsInterface(false);
		clazz.assertConstructor()
			.assertPublic()
			.assertThrows();
		clazz.assertMethod("getStartingLocation")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Location").clazz)
			.assertParameters()
			.assertThrows();
		clazz.assertMethod("setStartingLocation")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("model.Location").clazz)
			.assertThrows();
		clazz.assertMethod("getItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Item").clazz)
			.assertParameters(String.class)
			.assertThrows();
		clazz.assertMethod("addItem")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Item").clazz)
			.assertParameters(String.class, String.class)
			.assertThrows();
		clazz.assertMethod("getLocation")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Location").clazz)
			.assertParameters(String.class)
			.assertThrows();
		clazz.assertMethod("addLocation")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Location").clazz)
			.assertParameters(String.class, String.class)
			.assertThrows();
		clazz.assertMethod("getAction")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Action").clazz)
			.assertParameters(String.class)
			.assertThrows();
		clazz.assertMethod("addAction")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(cls("model.Action").clazz)
			.assertParameters(String.class)
			.assertThrows();
		clazz.assertMethod("onStart")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(void.class)
			.assertParameters(cls("effects.Effect").clazz)
			.assertThrows();
		clazz.assertMethod("getStartEffects")
			.assertPublic()
			.assertStatic(false)
			.assertReturns(java.util.List.class)
			.assertReturnsTypeArguments(cls("effects.Effect").clazz)
			.assertParameters()
			.assertThrows();
	}
	
	
	
	private final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	
	private AssertClass cls(String name) {
		return new AssertClass(name);
	}
	
	private class AssertClass {
		final String className;
		final Class<?> clazz;
		
		AssertClass(String className) {
			this.className = "bcu." + STUDENT_ID_NUMBER.toLowerCase() + ".adventure." + className;
			try {
				clazz = classLoader.loadClass(this.className);
			} catch(ClassNotFoundException e) {
				throw new AssertionError("class " + this.className + " not found.");
			}
		}
		
		AssertClass assertPublic() {
			if(!Modifier.isPublic(clazz.getModifiers())) {
				fail("class " + className + " must be public.");
			}
			return this;
		}
		
		AssertClass assertAbstract(boolean isAbstract) {
			if(Modifier.isAbstract(clazz.getModifiers()) != isAbstract) {
				fail("class " + className + " must " + (isAbstract ? "" : "not ") + "be abstract.");
			}
			return this;
		}
		
		AssertClass assertExtends(Class<?> superClazz) {
			if(clazz.getSuperclass() != superClazz) {
				fail("class " + className + " must extend " + superClazz.getSimpleName());
			}
			return this;
		}
		
		AssertClass assertIsInterface(boolean isInterface) {
			if(clazz.isInterface() != isInterface) {
				fail("class " + className + " must " + (isInterface ? "" : "not ") + "be an interface.");
			}
			return this;
		}
		
		AssertClass assertImplements(Class<?> interfaze) {
			for(Class<?> i : clazz.getInterfaces()) {
				if(i == interfaze) {
					return this;
				}
			}
			throw new AssertionError("class " + className + " must implement " + interfaze.getSimpleName());
		}
		
		AssertClass assertImplements(AssertClass interfaze) {
			return assertImplements(interfaze.clazz);
		}
		
		AssertMethod assertMethod(String methodName) {
			return new AssertMethod(clazz, methodName);
		}
		
		AssertConstructor assertConstructor(Class<?>... parameterTypes) {
			return new AssertConstructor(clazz, parameterTypes);
		}
	}
	
	private static Method findMethod(Class<?> clazz, String methodName) {
		for(Method m : clazz.getDeclaredMethods()) {
			if(m.getName().equals(methodName)) {
				return m;
			}
		}
		throw new AssertionError("Method " + clazz.getSimpleName() + "." + methodName + " not found.");
	}
	
	private class AssertMethod {
		final String methodName;
		final Method method;
		
		AssertMethod(Class<?> clazz, String methodName) {
			this.methodName = methodName;
			this.method = findMethod(clazz, methodName);
		}
		
		AssertMethod assertPublic() {
			if(!Modifier.isPublic(method.getModifiers())) {
				fail("Method " + methodName + " must be public.");
			}
			return this;
		}
		
		AssertMethod assertStatic(boolean isStatic) {
			if(Modifier.isStatic(method.getModifiers()) != isStatic) {
				fail("Method " + methodName + " must " + (isStatic ? "" : "not ") + "be static.");
			}
			return this;
		}
		
		AssertMethod assertAbstract(boolean isAbstract) {
			if(Modifier.isAbstract(method.getModifiers()) != isAbstract) {
				fail("Method " + methodName + " must " + (isAbstract ? "" : "not ") + "be abstract.");
			}
			return this;
		}
		
		AssertMethod assertReturns(Class<?> expectedReturnType) {
			assertSame(
				"Method " + methodName + " must return " + expectedReturnType.getSimpleName() + ".",
				expectedReturnType,
				method.getReturnType()
			);
			return this;
		}
		
		AssertMethod assertReturnsTypeArguments(Class<?>... expectedTypeArguments) {
			Type returnType = method.getGenericReturnType();
			if(!(returnType instanceof ParameterizedType)) {
				fail("Method " + methodName + " must have parameterized return type.");
			}
			
			ParameterizedType t = (ParameterizedType) returnType;
			Type[] actualTypeArguments = t.getActualTypeArguments();
			assertEquals(expectedTypeArguments.length, actualTypeArguments.length);
			
			for(int i = 0; i < expectedTypeArguments.length; ++i) {
				Class<?> et = expectedTypeArguments[i];
				Type at = actualTypeArguments[i];
				assertSame(
					"Type argument #" + i + " of method " + methodName + " must be " + et.getSimpleName() + ".",
					et,
					at
				);
			}
			
			return this;
		}
		
		AssertMethod assertParameters(Class<?>... expectedParameterTypes) {
			Class<?>[] actualParameterTypes = method.getParameterTypes();
			assertEquals(
				"Method " + method + " has must have " + expectedParameterTypes.length + " parameters.",
				expectedParameterTypes.length,
				actualParameterTypes.length
			);
			
			for(int i = 0; i < actualParameterTypes.length; ++i) {
				Class<?> expected = expectedParameterTypes[i];
				Class<?> actual = actualParameterTypes[i];
				assertSame(
					"Parameter #" + i + " of method " + methodName + " must return " + expected.getSimpleName() + ".",
					expected,
					actual
				);
			}
			
			return this;
		}
		
		
		AssertMethod assertThrows(Class<?>... expectedExceptionTypes) {
			assertThrownExceptions(method, expectedExceptionTypes);
			return this;
		}
	}
	
	private class AssertConstructor {
		final Constructor constructor;
		
		AssertConstructor(Class<?> clazz, Class<?>[] parameterTypes) {
			try {
				constructor = clazz.getDeclaredConstructor(parameterTypes);
			} catch(NoSuchMethodException e) {
				throw new AssertionError("Constructor of required signature not found.");
			}
		}
		
		AssertConstructor assertPublic() {
			if(!Modifier.isPublic(constructor.getModifiers())) {
				fail("Constructor must be public.");
			}
			return this;
		}
		
		AssertConstructor assertThrows(Class<?>... expectedExceptionTypes) {
			assertThrownExceptions(constructor, expectedExceptionTypes);
			return this;
		}
	}
	
	private static void assertThrownExceptions(Executable executable, Class<?>[] expectedExceptionTypes) {
		Class<?>[] actualExceptionTypes = java.util.Arrays.stream(executable.getExceptionTypes())
			.filter(ec -> !RuntimeException.class.isAssignableFrom(ec))
			.toArray(Class[]::new);
		
		java.util.Arrays.sort(expectedExceptionTypes, java.util.Comparator.comparing(Class::getCanonicalName));
		java.util.Arrays.sort(actualExceptionTypes, java.util.Comparator.comparing(Class::getCanonicalName));
		
		assertEquals(
			executable.getName() + " must declare " + expectedExceptionTypes.length + " exception(s) with the throws keyword.",
			expectedExceptionTypes.length,
			actualExceptionTypes.length
		);
		
		for(int i = 0; i < expectedExceptionTypes.length; ++i) {
			Class<?> expected = expectedExceptionTypes[i];
			Class<?> actual = actualExceptionTypes[i];
			assertSame(
				executable.getName() + " must declare that it throws " + expected.getSimpleName() + ".",
				expected,
				actual
			);
		}
	}
}
