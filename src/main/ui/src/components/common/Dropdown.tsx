import * as React from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import {useEffect} from "react";

interface DropdownProps {
    options: Record<string, never>[],
    onChange: (o: string) => void;
    fieldToShow: string,
    additionalField: string,
    label?: string,
    selected?: string,
    shouldClear?: boolean;
}

const Dropdown = ({
                      options,
                      fieldToShow,
                      additionalField,
                      onChange,
                      label = '',
                      selected,
                      shouldClear = false,
                  }: DropdownProps): JSX.Element => {
    const [selectedOption, setSelectedOption] = React.useState(selected || '');

    useEffect(() => {
        setSelectedOption('');
    }, [shouldClear]);

    const handleChange = (event: SelectChangeEvent) => {
        setSelectedOption(event.target.value as string);
        onChange(event.target.value as string);
    };

    return (
        <Box sx={{ minWidth: 450 }}>
            <FormControl fullWidth>
                {!selectedOption ? <InputLabel id="dropdownLabel">{label}</InputLabel> : null}
                <Select
                    labelId="dropdownLabel"
                    id="dropdownId"
                    value={selectedOption}
                    label={label}
                    onChange={handleChange}
                >
                    {options.map(o => (
                        <MenuItem key={o[fieldToShow]} value={o[fieldToShow]}>{o[fieldToShow]} ({o[additionalField]})</MenuItem>
                    ))}
                </Select>
            </FormControl>
        </Box>
    );
}

export default Dropdown;