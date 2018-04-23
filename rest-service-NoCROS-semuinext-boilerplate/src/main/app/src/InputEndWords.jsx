import React ,{Component}from 'react';
import PropTypes from 'prop-types';
import { withStyles } from 'material-ui/styles';
import Input, { InputLabel } from 'material-ui/Input';
import { FormControl, FormHelperText } from 'material-ui/Form';
import Button from 'material-ui/Button';
import Paper from 'material-ui/Paper';
import Typography from 'material-ui/Typography';

const styles = theme => ({
    root: {
        display: 'flex',
        flexWrap: 'wrap',
    },
    formControl: {
        margin: theme.spacing.unit,
        minWidth: 120,
    },
    selectEmpty: {
        marginTop: theme.spacing.unit * 2,
    },
});


let endWords={
    startingWord:"",
    endingWord:"",
};
function SetElem(elem,val){
    endWords[elem]=val;
}


class SimpleSelect extends Component {



    constructor(props) {
        super(props);

        this.state = {
            isLoading:false,
            startingWord : "",
            endingWord : "",
            result:false,
            found:false,
        };
    }




    onClick = () => {
        this.setState({
            staringWord:endWords["staringWord"],
            endingWord:endWords["endingWord"],
            found:false,
        });
        console.log(endWords);
        //POST

        //GET
        //
        //if get found==true set this.state.found=true
        //else false
        this.setState({
            found:true,
            hasValue:true,
            result:"ladder should be here.",
        });

    };
    render() {

        const { classes } = this.props;
        const { startingWord, endingWord,found,hasValue} = this.state;


        return (
            <div>
            <form className={classes.root} autoComplete="off">
                <FormControl className={classes.formControl}>
                    <InputLabel htmlFor="name-input">ex. code</InputLabel>
                    <Input
                        id="start-word"
                        onChange={(event)=>{SetElem("startingWord",event.target.value);}}

                    />
                    <FormHelperText>Input Starting Word</FormHelperText>
                </FormControl>
                <FormControl className={classes.formControl}>
                    <InputLabel htmlFor="name-input">ex. data</InputLabel>
                    <Input
                        id="end-word"
                        onChange={(event)=>{SetElem("endingWord",event.target.value);}}
                    />
                    <FormHelperText>Input Ending Word</FormHelperText>
                </FormControl>
                <Button
                    variant="raised"
                    color="primary"
                    onClick={this.onClick}
                >
                    Find Ladder
                </Button>
            </form>
                <ul>{found ? <Found /> : <Notfound/>} </ul>
            </div>
        );
    }
}

function Found(){
    if(endWords["startingWord"]&&endWords["endingWord"])
    return (
        <div>
            <Paper  elevation={4}>
                <Typography  component="p">
                    Result
                </Typography>
                <Typography  variant="headline" component="h3">
                    ladder comes here.
                </Typography>
            </Paper>
        </div>
    );
    return(<div></div>)
};

function Notfound(){
    if(endWords["startingWord"]&&endWords["endingWord"])
    return(
    <div>
        <Paper elevation={4}>
            <Typography variant="headline" component="h3">
                Ladder from{" {" + endWords["startingWord"] + "} to {" + endWords["endingWord"] + "} "}not found.
            </Typography>
        </Paper>
    </div>
    );
    return (<div></div>);
};


SimpleSelect.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(SimpleSelect);