# :currency_exchange: Currency Converter App

This project is a simple currency converter that uses the ExchangeRate-API to convert currencies based on user input. The application prompts the user to enter the source currency, the target currency, and the amount to be converted. The conversion result is displayed along with a timestamp of when the conversion was performed. The application also stores conversion history in a log file.

## :high_brightness: Features

- User-friendly interface to input currencies and amounts.
- Fetches real-time conversion rates from ExchangeRate-API.
- Displays the conversion result with proper currency formatting.
- Logs conversion history in a `conversion_history.log` file.
- Allows users to view past conversions from the log file.
  
## :memo: Setup Instructions

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/YOUR_USERNAME/currency-converter.git

2. Navigate to the project directory:

   ```bash
   cd currency-converter

3. Add your ExchangeRate-API key in the ApiClient class:

   ```bash
   URI link = URI.create("https://v6.exchangerate-api.com/v6/YOUR_API_KEY/pair/" + base + "/" + target + "/" + amount);

4. Compile and run the program:

   ```bash
   javac -d bin src/com/alurachallenge/conversor/*.java
   java -cp bin com.alurachallenge.conversor.MainApp

## :computer: Usage
    
- The program will display a list of available currencies.
- Enter the currency code for the source and target currencies.
- Enter the amount you wish to convert.
- The program will display the converted amount and log the result with the timestamp.
- You can choose to perform another conversion or exit the program.
- You can also view the conversion history saved in the conversion_history.log file.

  ## Welcome and First Menu

      ***-***-***-Bienvenido a la App Convertidor de Monedas-***-***-***

      Escriba el codigo de la moneda origen del siguiente listado: (ej. CLP) 
      USD   Dólar estadounidense     EUR   Euro                     JPY   Yen japonés              
      GBP   Libra esterlina          AUD   Dólar australiano        CAD   Dólar canadiense         
      CHF   Franco suizo             CNY   Yuan chino               MXN   Peso mexicano            
      BRL   Real brasileño           ARS   Peso argentino           COP   Peso colombiano          
      CLP   Peso chileno             PEN   Sol peruano              DOP   Peso dominicano

  ## Example Output
      -------------------------------------------------
      Resultado obtenido a las : 2024-10-24T17:26:32  --  $1,234.00 USD equivalen a: $5,257,478.97 COP
      --------------------------------------------------

  ## Conversion History Example:
      ***-***-***-Historial de Conversiones-***-***-***
      2024-10-24T17:26:32  --  $1,234.00 USD equivalen a: $5,257,478.97 COP

  ## Second menu:
      ***-***-***-Seleccione una opción-***-***-***
      1 - Realizar una nueva conversión
      2 - Ver el historial de conversiones
      3 - Salir

## :loop: Project Structure  

     ```bash
    ├── src
    │   ├── main
    │   │   ├── java
    │   │   │   ├── com.alurachallenge.conversor
    │   │   │   │   ├── MainApp.java        # Main class that drives the application
    │   │   │   │   ├── CurrencyUtils.java  # Utility class for currency validation and display
    │   │   │   │   ├── ApiClient.java      # Handles API requests to ExchangeRate-API
    │   │   │   │   ├── ConversionHistoryManager.java # Manages the conversion history log
    │   └── resources
    │       └── conversion_history.log      # Log file storing conversion history (if present)


## :bookmark_tabs: Requirements

- Java 17 or higher.
- Gson library to handle JSON parsing.
- ExchangeRate-API (free or paid subscription for access to the API).

## :copyright: Licence

This project is not under any specific license.

## :octocat: Autor
Yohan Manuel Tocarruncho Urrea    
