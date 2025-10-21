export class Flight {
    
    isFull: boolean;
    flightid: Number;//int not angular compatable.
	origin: string;
	destination: string;
	arrival: Date;// localDate not angular compatable.
	departure: Date;// localDate not angular compatable.
	airline: string;
	price: Number;//float not angular compatable.
    constructor(
        isFull: boolean,//boolean to register if the flight is full.
        //could be a cool feature to add...
        flightid: Number,
        origin: string,
        destination: string,
        arrival: Date,
        departure: Date,
        airline: string,
        price: Number,
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
    flightFull() {//use set & get have a radio button for
    //  view users and admin might both want to see full flights.
        this.isFull = !this.isFull;// this method flips the boolean right...?
    }
}
