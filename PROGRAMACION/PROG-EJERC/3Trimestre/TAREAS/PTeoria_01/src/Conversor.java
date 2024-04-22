public class Conversor {
    public static Float celsiusFarenheit(Float celsius) {
        //(0 °C × 9 / 5) + 32 = 32 °F
        return celsius*9/5+32;
    }
    public static Float fahrenheitCelsius(Float fahrenheit) {
        //(32 °F − 32) × 5 / 9 = 0 °C
        return (fahrenheit-32)*5/9;
    }
}
