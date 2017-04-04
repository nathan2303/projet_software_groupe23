package Main;

public class SerialNumberGenerator { private static SerialNumberGenerator instance = null;
private int num;
// private constructor: returns the unique SerialNumberGenerator object
private SerialNumberGenerator(){}
// public getInstance method
public static SerialNumberGenerator getInstance() { if (instance==null) { instance = new SerialNumberGenerator();
}return instance;
}
// public method to obtain next unique serialNumber
public int getNextSerialNumber(){ return num++;
}

public static void main(String[] args) {
	SerialNumberGenerator s = SerialNumberGenerator.getInstance();
}
}