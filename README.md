# Address formatter

Address formatter converts raw string into structured object with house number and street fields.

### General approach

Address raw strings can take wide variety of formats and it's a hard task to solve them all at the same time. 
Thus, I have decided to split complicated task into smaller sub-tasks.

In implementation `ParserResolver` selects most relevant parser which tries to extract Street and Housenumber Regexp 
groups.

put diagram here

There are 3 main cases that are based on test data, but I can imagine there are many more. Once new address pattern is 
discovered we can add new extra parser.   


### Running

```
./gradlew run --args="testalle 42"
```

# Testing

Check out `AddressFixture` with some predefined test data.

```
./gradlew test
```