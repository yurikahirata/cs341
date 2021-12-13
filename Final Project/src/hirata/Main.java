package hirata;

public class Main {

	public static void main(String[] args) {

		// Creating canvas for animation
		Canvas canvas = new Canvas();
		canvas.requestFocus();
	
		// Creating GameObject A
		Type_A_GameObject gameObjectA = new Type_A_GameObject(500, 100);
		gameObjectA.setVelocity(5);
		canvas.addGameObject(gameObjectA);
		
		// Creating GameObject B and adapter
		Type_B_GameObject gameObjectB = new Type_B_GameObject();
		Type_B_GameObject_Adapter adaptedB = new Type_B_GameObject_Adapter(50, 200, gameObjectB);
		adaptedB.setVelocity(5);
		adaptedB.setVelocityY(9);
		canvas.addGameObject(adaptedB);
		
		// Creating GameObject C
		Type_C_GameObject gameObjectC = new Type_C_GameObject(200, 350);
		gameObjectC.setVelocity(5);
		canvas.addGameObject(gameObjectC);
		
		// Creating GameObject D
		Type_D_GameObject user = new Type_D_GameObject(400, 600);
		user.setVelocity(5);
		canvas.addGameObject(user);
		
	}

}