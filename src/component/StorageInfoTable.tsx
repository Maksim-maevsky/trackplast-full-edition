import * as React from 'react';
import {styled} from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, {tableCellClasses} from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {PartStorageInfo} from "../pojo/types";


const StyledTableCell = styled(TableCell)(({theme}) => ({
    [`&.${tableCellClasses.head}`]: {
        backgroundColor: "#1976d2",
        color: theme.palette.common.white,
    },
    [`&.${tableCellClasses.body}`]: {
        fontSize: 14,
    },
}));

const StyledTableRow = styled(TableRow)(({theme}) => ({
    '&:nth-of-type(odd)': {
        backgroundColor: theme.palette.action.hover,
    },
    '&:last-child td, &:last-child th': {
        border: 0,
    },
}));

const logoStyles = {
    display: 'flex',
    width: 800

}

export interface IPartStorageInfo {

    partStorageInfo: PartStorageInfo[]

}


export function StorageInfoTable(props: IPartStorageInfo) {

    return (
        <>
            <TableContainer component={Paper} sx={logoStyles}>
                <Table sx={{minWidth: 500}} aria-label="customized table">
                    <TableHead>
                        <TableRow>
                            <StyledTableCell>Название склада</StyledTableCell>
                            <StyledTableCell align="center">Количество наименований</StyledTableCell>
                            <StyledTableCell align="center">Обем по мин. цене</StyledTableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {props.partStorageInfo.map((psi) => (
                            <StyledTableRow key={psi.partStorage.id}>
                                <StyledTableCell component="th" scope="row">{psi.partStorage.name}</StyledTableCell>
                                <StyledTableCell align="center">{psi.countOfParts}</StyledTableCell>
                                <StyledTableCell align="center">{psi.volumeAtALowPrice}</StyledTableCell>
                            </StyledTableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

        </>
    );
}