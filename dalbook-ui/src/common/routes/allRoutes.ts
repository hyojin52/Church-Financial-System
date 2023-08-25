import { ComponentType, lazy } from 'react';
import { ROUTE_PATH } from "@common/routes/router";

//항목 관리
export const CategoryListPage = lazy(() => import('@pages/Category/CategoryList'));

export type TPrivateAuthorization =
    | 'creationGranted'
    | 'deletionGranted'
    | 'readGranted'
    | 'distributionGranted'
    | 'custom';

export type TRoute = {
    path: string;
    name: string;
    authorization?: TPrivateAuthorization;
    component: ComponentType;
};

/* Routes */
//항목 관리
export const categoryListRoute = {
    path: ROUTE_PATH.CATEGORY_LIST,
    name: '항목',
    component: CategoryListPage
};



// All Routes
export const allRoutes: TRoute[] = [
    // 항목 관리
    categoryListRoute,
];
