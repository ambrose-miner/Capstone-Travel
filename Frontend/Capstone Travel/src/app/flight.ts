export class Flight {
    
    isFull: boolean;
    flightid: int;//int not angular compatable.
	origin: string;
	destination: string;
	arrival: localDate;// localDate not angular compatable.
	departure: localDate;// localDate not angular compatable.
	airline: string;
	price: float;//float not angular compatable.
    constructor(
        isFull: boolean,//boolean to register if the flight is full.
        //could be a cool feature to add...
        flightid: int,
        origin: string,
        destination: string,
        arrival: localDate,
        departure: localDate,
        airline: string,
        price: float,
    ){
    this.isFull = isFull;
    this.flightid = flightid
    this.origin = origin;
    this.destination = destination;
    this.arrival = arrival;
    this.departure = departure;
    this.airline = airline;
    this.price = price;
    }
    loginStatus() {
        this.isFull = !this.isFull;// this method flips the boolean right...?
    }
}
