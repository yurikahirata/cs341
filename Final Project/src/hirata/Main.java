package hirata;

public class Main {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
	

		Type_A_GameObject gameObjectA = new Type_A_GameObject(500, 100);
		gameObjectA.setVelocity(5);
		canvas.addGameObject(gameObjectA);
		
		Type_B_GameObject gameObjectB = new Type_B_GameObject();
		Type_B_GameObject_Adapter adaptedB = new Type_B_GameObject_Adapter(50, 200, gameObjectB);
		adaptedB.setVelocity(5);
		adaptedB.setVelocityY(10);
		canvas.addGameObject(adaptedB);
		
		Type_C_GameObject gameObjectC = new Type_C_GameObject(200, 350);
		gameObjectC.setVelocity(5);
		canvas.addGameObject(gameObjectC);
		
		Type_D_GameObject user = new Type_D_GameObject(400, 600);
		user.setVelocity(5);
		canvas.addGameObject(user);
		
	}

}