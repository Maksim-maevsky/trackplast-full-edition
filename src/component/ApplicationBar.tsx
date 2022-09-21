import React from 'react';
import {AppBar, Box, Button, Container, Toolbar, Typography} from "@mui/material";


export function ApplicationBar() {

    const logoStyles = {
        display: 'flex',
        flexGrow: 1,
        justifyContent: 'center'

    }

    return (
        <AppBar position='fixed'>
            <Container fixed>
                <Toolbar>
                    <Typography variant="h5" sx={logoStyles}>TRACKPLAST</Typography>
                    <Box>
                        <Button color="inherit" variant="outlined">
                            LogIn
                        </Button>
                    </Box>
                </Toolbar>
            </Container>
        </AppBar>
    );
};
