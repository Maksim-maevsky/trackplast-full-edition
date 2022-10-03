import React from 'react';
import {AppBar, Box, Button, Container, Toolbar, Typography} from "@mui/material";
import MenuButtonNavigation from "./MenuButtonNavigation";


export function ApplicationBar() {

    const logoStyles: React.CSSProperties = {
        display: 'flex',
        flexGrow: 1,
        justifyContent: 'space-between',
        alignItems: 'center'

    }

    return (
        <AppBar position='fixed'>
            <Container fixed>
                <Toolbar>
                    <Container style={logoStyles}>
                        <Typography variant="h5">TRACKPLAST</Typography>
                        <MenuButtonNavigation/>
                        <Box>
                            <Button color="inherit" variant="outlined">
                                LogIn
                            </Button>
                        </Box>
                    </Container>
                </Toolbar>
            </Container>
        </AppBar>
    );
};
