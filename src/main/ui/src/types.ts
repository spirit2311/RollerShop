export interface Skate {
    uuid: string;
    discipline: Discipline;
    brand: Brand;
    model: string;
    year: number;
    price: number;
    description: string;
}

export interface SkateJsonModel {
    model: string;
    year: number;
    price: number;
    description: string;
    disciplineId: number;
    brandId: number;
}

export interface Brand {
    brand: string;
}

export interface Discipline {
    discipline: string;
}

export interface RawDiscipline extends Discipline {
    id: number,
    uuid: string
}

export interface RawBrand extends Brand {
    id: number,
    uuid: string
}