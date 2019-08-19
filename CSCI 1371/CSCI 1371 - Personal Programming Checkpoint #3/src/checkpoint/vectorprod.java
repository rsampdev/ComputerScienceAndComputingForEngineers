package checkpoint;

public class vectorprod {

	public static void main(String[] args) {
		Vector3f vec1 = new Vector3f(2, -1, 3);
		Vector3f vec2 = new Vector3f(-1, 1, 4);
		Vector3f vec3 = Vector3f.crossProduct(vec1, vec2);

		System.out.println("Cross Product: " + vec3.toString());
	}

	private static class Vector3f {
		float x;
		float y;
		float z;

		Vector3f(float x, float y, float z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static Vector3f crossProduct(Vector3f vec1, Vector3f vec2) {
			float x = (vec1.y * vec2.z) - (vec1.z * vec2.y);
			float y = (-vec1.x * vec2.z) + (vec1.z * vec2.x);
			float z = (vec1.x * vec2.y) - (vec1.y * vec2.x);

			return new Vector3f(x, y, z);
		}

		@Override
		public String toString() {
			return "X: " + this.x + ", Y: " + this.y + ", Z: " + this.z;
		}

	}

}
